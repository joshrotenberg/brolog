(ns brolog.logging
  (:use brolog.constants
        brolog.jna))

(defonce ^:dynamic *use-agent* (atom false))
(defonce ^:dynamic *logging-agent* (agent nil :error-mode :continue))

(defn init-logging
  "Initialize logging. Set up the identity and facility, and optionally
  pass along any syslog options. To use a Clojure agent for asynchronous
  logging, use :use-agent true."
  [ident facility & {:keys [syslog-options use-agent]}]
  (reset! *use-agent* use-agent)
  (openlog ident syslog-options facility))

;; the actual log method. if the use-agent flag was set to true,
;; use send-off
(defn log*
  [priority msg & rest]
  (if @*use-agent*
    (do
      (send-off *logging-agent* (fn [_] (syslog priority msg rest))))
    (syslog priority msg rest)))

(def emerg (partial log* log-emerg))
(def alert (partial log* log-alert))
(def crit (partial log* log-crit))
(def error (partial log* log-err))
(def err (partial log* log-err)) ;; for consistency, i guess
(def warning (partial log* log-warning))
(def notice (partial log* log-notice))
(def info (partial log* log-info))
(def debug (partial log* log-debug))


