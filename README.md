# brolog

JNA Access to syslog(3) in Clojure

## Rationale

I know. There are 50 ways to log stuff in Java-land. log4this and
log4that. They all work pretty well. But I wanted old school, direct
access to syslog because I'm a dinosaur, OK?

## Usage

```clojure
(ns your.ns
    (:use brolog.core))

(init-logging "myapp" log-local7)

;; after init, the interface looks like core.tools logging

(debug "some debugging message")
(info "something informational")
```

To log to a different syslog facility than the one you initialized brolog with:

```clojure
(binding [brolog.logging/*logging-facility* log-local1]
  (info "this message is logged to the local7 facility"))
```

## License

Copyright (C) 2012 Josh Rotenberg

Distributed under the Eclipse Public License, the same as Clojure.
