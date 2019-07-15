(ns login-sample.routes.login
  (:require
    [login-sample.layout :as layout]
    [login-sample.db.core :as db]
    [clojure.java.io :as io]
    [login-sample.middleware :as middleware]
    [ring.util.http-response :as response]
    [ring.util.response :refer [response]]))

(defn login-page [request]
  (layout/render request "login.html"))

(defn login! [request]
  (let [
        username (get-in request [:form-params "username"])
        session (:session request)]
  (do (let [ updated-session (assoc session :username username)]
                (-> (layout/render request "home.html" 
                    {:docs (-> "docs/docs.md" io/resource slurp)
                    :username (:username updated-session)}
                    )
                    (assoc :session updated-session))))
  ))

(defn login-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/login" {:get login-page 
              :post login!}]
   ])