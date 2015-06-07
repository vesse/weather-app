(defproject backend "0.1.0-SNAPSHOT"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [compojure "1.2.1"]
                           [ring/ring-core "1.3.1"]
                           [ring/ring-devel "1.3.1"]
                           [ring/ring-jetty-adapter "1.3.1"]
                           [ring/ring-json "0.3.1"]
                           [http-kit "2.1.19"]
                           [clojurewerkz/cassaforte "2.0.0"]]
            :main backend.core)
