(ns brolog.jna
  (:use brolog.constants)
  (:import [com.sun.jna Library Native Platform]))

(def library "c")

(defn openlog
  [ident option facility]
  (let [f (com.sun.jna.Function/getFunction library "openlog")]
    (.invoke f Integer (to-array [ident option facility]))))

(defn syslog
  [priority format & args]
  (let [f (com.sun.jna.Function/getFunction library "syslog")
        params (flatten (list priority format args))]
    (.invoke f Integer (to-array params))))

(defn closelog
  []
  (let [f (com.sun.jna.Function/getFunction library "closelog")]
    (.invoke f Integer (to-array []))))