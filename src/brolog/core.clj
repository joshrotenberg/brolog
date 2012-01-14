(ns brolog.core
  (:use brolog.jna))

(def priority
  {:log-emerg 0
   :log-alert 1
   :log-crit 2
   :log-err 3
   :log-warning 4
   :log-notice 5
   :log-info 6
   :log-debug 7})

(defn- <<3
  [n]
  (bit-shift-left n 3))

(def facility
  {:log-kern (<<3 0)
   :log-user (<<3 1)
   :log-mail (<<3 2)
   :log-daemon (<<3 3)
   :log-auth (<<3 4)
   :log-syslog (<<3 5)
   :log-lpr (<<3 6)
   :log-news (<<3 7)
   :log-uucp (<<3 8)
   :log-cron (<<3 9)
   :log-authpriv (<<3 10)
   :log-ftp (<<3 11)
   :log-ntp (<<3 12)
   :log-security (<<3 13)
   :log-local0 (<<3 16)
   :log-local1 (<<3 17)
   :log-local2 (<<3 18)
   :log-local3 (<<3 19)
   :log-local4 (<<3 20)
   :log-local5 (<<3 21)
   :log-local6 (<<3 22)
   :log-local7 (<<3 23)  })

(def options
  {:log_pid (byte 0x01) ;; log the pid
   :log_cons (byte 0x02) ;; log to the console if errors in sending
   :log_odelay (byte 0x04) ;; delay open until first call
   :log_ndelay (byte 0x08) ;; don't delay open
   :log_nowait (byte 0x10) ;; don't wait for console forks (deprecated)
   :log_perror (byte 0x20) ;; log to stderr as well
   }) 

(defn init-brolog
  [ident option facility])

(defn log*
  [priority & args])


