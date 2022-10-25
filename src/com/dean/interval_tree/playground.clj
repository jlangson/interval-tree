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
            [com.dean.interval-tree.tree.tree :as t-t]
            [com.dean.interval-tree.core :as core]
            [flow-storm.api :as fs-api]))

(def foo (shuffle (range 500000)))
(def bar (shuffle (range 1000000)))
(def baz (shuffle (range 2000000)))

(def s0 (shuffle (range 0 1000000 2)))
(def s1 (shuffle (range 0 1000000 3)))

(def x (core/ordered-set foo))
(def y (core/ordered-set bar))
(def z (core/ordered-set baz))

;(def a (core/interval-map foo))
;(def b (core/interval-map bar))
;(def c (core/interval-map baz))

(def f
  (core/interval-map
    {[1 3] :x1
     [4 7] :x2
     [8 9] :x3
     [0 5] :x4
     [6 8] :x5
     [9 9] :x6
     [3 9] :x7
     [4 5] :x8}))
(def g
  (core/interval-map {[1 2] :x1
                      [4 5] :x2
                      [8 12] :x3
                      [0 3] :x4
                      [2 8] :x5
                      [1 4] :x6
                      [12 14] :x7
                      [-1 2] :x8}))


(println "playground")

;(mm/measure [1])

(defn rand-map [size]
  (doall (core/interval-map (into {} (for [i (range size)]
                                       {[0 (rand-int 50)] i}))))
  )

(defn just-time [f a]
  (time (do (f a) nil)))

(defn rand-map2 [size]
  (for [i (range size)]
    {[0 (rand-int 50)] i}) )

(def xx (rand-map 500000))
(def yy (rand-map 1000000))
(def zz (rand-map 2000000))
(def zzzz (rand-map 990000000))
(def simple (rand-map 25))

(comment

  ;;massive map for querying

  (fs-api/instrument-forms-for-namespaces #{"com.dean.interval-tree.core"} {})

  (fs-api/local-connect)
  ;tracing #rtrace, #ctrace, #trace

  (try (mm/measure [1]) (catch Exception e (pst e)))

  (mm/measure [1])

  (mm/measure (doall (range 500000)))

  (mm/measure (doall (range 1000000)))

  (mm/measure (core/interval-map
                            {[1 3] :x1
                             [4 7] :x2
                             [8 9] :x3
                             [0 5] :x4
                             [6 8] :x5
                             [9 9] :x6
                             [3 9] :x7
                             [4 5] :x8}))




  (mm/measure {[1 3] :x1
               [4 7] :x2
               [8 9] :x3
               [0 5] :x4
               [6 8] :x5
               [9 9] :x6
               [3 9] :x7
               [4 5] :x8})

  (mm/measure (doall (for [i (range 500000)]
                       {[i i] i})))

  #rtrace
  (doall (for [i (range 20)]
           {[0 (rand-int 50)] i}))

  (mm/measure (core/interval-map (into {} (for [i (range 70000)]
                                            {[i i] i}))))

  (mm/measure (doall (rand-map 2000000)))

  )





(defn just-time [f]
  (print (time f)))