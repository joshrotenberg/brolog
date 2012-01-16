(ns brolog.constants)

;; priority
(def log-emerg 0)
(def log-alert 1)
(def log-crit 2)
(def log-err 3)
(def log-warning 4)
(def log-notice 5)
(def log-info 6)
(def log-debug 7)

(defn- <<3
  [n]
  (bit-shift-left n 3))

;; facility
(def log-kern (<<3 0))
(def log-user (<<3 1))
(def log-mail (<<3 2))
(def log-daemon (<<3 3))
(def log-auth (<<3 4))
(def log-syslog (<<3 5))
(def log-lpr (<<3 6))
(def log-news (<<3 7))
(def log-uucp (<<3 8))
(def log-cron (<<3 9))
(def log-authpriv (<<3 10))
(def log-ftp (<<3 11))
(def log-ntp (<<3 12))
(def log-security (<<3 13))
(def log-local0 (<<3 16))
(def log-local1 (<<3 17))
(def log-local2 (<<3 18))
(def log-local3 (<<3 19))
(def log-local4 (<<3 20))
(def log-local5 (<<3 21))
(def log-local6 (<<3 22))
(def log-local7 (<<3 23))

;; options
(def log-pid (byte 0x01)) ;; log the pid
(def log-cons (byte 0x02)) ;; log to the console if errors in sending
(def log-odelay (byte 0x04)) ;; delay open until first call
(def log-ndelay (byte 0x08)) ;; don't delay open
(def log-nowait (byte 0x10)) ;; don't wait for console forks (deprecated)
(def log-perror (byte 0x20)) ;; log to stderr as well
