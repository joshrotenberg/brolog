(ns brolog.extras
  (:use brolog.constants
        brolog.logging))

(defmacro log-timing
  "Given a log priority and some identifying string, runs the body and logs
  the time it took to run."
  [priority ident & body]
  `(let [start# (. System (nanoTime))
         ret# ~@body
         elapsed# (/ (double (- (. System (nanoTime)) start#)) 1000000.0)]
     (log* ~priority "%s elapsed time: %.3f msecs" ~ident elapsed#)
     ret#))

