(ns com.dean.interval-tree.playground
  (:require [clj-memory-meter.core :as mm]
            [com.dean.interval-tree.tree.interval :as interval]
            [com.dean.interval-tree.tree.interval-map :as i-map]
            [com.dean.interval-tree.tree.interval-set :as i-s]
            [com.dean.interval-tree.tree.node :as t-node]
            [com.dean.interval-tree.tree.order :as t-order]
            [com.dean.interval-tree.tree.ordered-map :as o-map]
            [com.dean.interval-tree.tree.ordered-set :as o-set]
            [com.dean.interval-tree.tree.protocol :as p]
            [com.dean.interval-tree.tree.root :as t-root]
            [com.dean.interval-tree.tree.tree :as t-t]))



(println "playground")

(mm/measure [1])

(comment
  (try (mm/measure [1]) (catch Exception e (pst e)))

  (mm/measure [1])

  )