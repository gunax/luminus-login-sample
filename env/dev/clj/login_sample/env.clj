(ns login-sample.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [login-sample.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[login-sample started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[login-sample has shut down successfully]=-"))
   :middleware wrap-dev})
