(ns login-sample.routes.about
  (:require
    [login-sample.layout :as layout]
    [login-sample.db.core :as db]
    [clojure.java.io :as io]
    [login-sample.middleware :as middleware]
    [ring.util.http-response :as response]
    [ring.util.response :refer [response]]))

(defn about-page [request]
  (layout/render request "about.html"))

(defn about-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/about" {:get about-page}]
   ])