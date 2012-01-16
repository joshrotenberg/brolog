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

(init-brolog log-local7)

;; after init, the interface looks like core.tools logging

(debug "some debugging message")
(info "something informational")
```

## License

Copyright (C) 2012 Josh Rotenberg

Distributed under the Eclipse Public License, the same as Clojure.
