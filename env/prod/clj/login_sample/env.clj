(ns login-sample.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[login-sample started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[login-sample has shut down successfully]=-"))
   :middleware identity})
