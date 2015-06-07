(ns backend.core
  (:use [org.httpkit.server :only [run-server]]
        [compojure.core :only [defroutes POST]]
        [compojure.handler :only [api]]
        [ring.middleware.json :only [wrap-json-response wrap-json-body]]
        [ring.util.response :only [response]]
        [clojurewerkz.cassaforte.client :as client]
        [clojurewerkz.cassaforte.cql :as cql]))

; Cassandra session, needed to be able to use CQL commands
(def session (client/connect ["localhost"] {:keyspace "simpledemo"}))

; POST handler
(defn- store-reading [request]
  (prn (:body request))
  (response {:status "ok"}))

; Routes
(defroutes api-routes
           (POST "/readings" [] store-reading))

; The web app
(defn app []
  (->
    (api #'api-routes)
    (wrap-json-body {:keywords? true})
    (wrap-json-response)))

; Method for starting the web app
(defn- start [& args]
  (run-server (app) {:port 4000})
  (prn "Server running on port 4000"))

(defn- -main [& args]
  (apply start args))
