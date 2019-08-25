(ns login-sample.routes.home
  (:require
    [login-sample.layout :as layout]
    [login-sample.db.core :as db]
    [clojure.java.io :as io]
    [login-sample.middleware :as middleware]
    [ring.util.http-response :as response]))

(defn home-page [request]
  (let [session (:session request)]
  (layout/render request "home.html" 
    {:username (:username session)}
    )))

(defn login! [request]
  (let [
        username (get-in request [:form-params "username"])
        session (:session request)]
  (do (let [ updated-session (assoc session :username username)]
                (-> (layout/render request "home.html" 
                      {:username (:username updated-session)}
                    )
                    (assoc :session updated-session))))
  ))

  (defn logout! [request]
    (do 
      (assoc request :session nil)
      (layout/render nil "home.html")
    )
  )

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page
         :post login!}]
   ["/logout" {:post logout!}]
   ])

