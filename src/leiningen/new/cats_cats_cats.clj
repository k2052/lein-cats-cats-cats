(ns leiningen.new.cats-cats-cats
  (:require [leiningen.new.templates :refer [renderer raw-resourcer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cats-cats-cats"))
(def raw (raw-resourcer "cats-cats-cats"))

(defn cats-cats-cats
  "adds cats to any project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' cats-cats-cats project.")
    (->files data
             ["src/{{sanitized}}/cats.clj" (render "cats.clj" data)]
             ["resources/cats.gif" (raw "cats.gif")])))
