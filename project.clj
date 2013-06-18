(defproject brolog "0.0.1"
  :url "https://github.com/joshrotenberg/brolog"
  :description "JNA Access to syslog(3) in Clojure"
  ; This awt.headless=true prevents JNA from popping up a window when we run lein repl.
  ; http://stackoverflow.com/questions/11740012/clojure-java-pop-up-window
  :jvm-opts ["-Djava.awt.headless=true"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [net.java.dev.jna/jna "3.4.0"]]
  :dev-dependencies [[lein-clojars "0.9.1"]])
