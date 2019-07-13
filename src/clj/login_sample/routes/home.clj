(ns login-sample.routes.home
  (:require
    [login-sample.layout :as layout]
    [login-sample.db.core :as db]
    [clojure.java.io :as io]
    [login-sample.middleware :as middleware]
    [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]])

