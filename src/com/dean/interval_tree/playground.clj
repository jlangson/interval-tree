(ns com.dean.interval-tree.playground
  (:require [com.dean.interval-tree.tree.tree :as tree]
            [com.dean.interval-tree.tree.node :as node :refer [leaf? leaf -k -v -l -r -x -z -kv]]
            [flow-storm.api :as fs]))



(defn make-integer-tree
  ([size] (reduce tree/node-add (node/leaf) (shuffle (range size))))
  ([start end] (reduce tree/node-add (node/leaf) (shuffle (range start end))))
  ([start end step] (reduce tree/node-add (node/leaf) (shuffle (range start end step)))))

(defn make-string-tree [size]
  (reduce tree/node-add (node/leaf) (map str (shuffle (range size)))))

(defn make-tree [values]
  (reduce tree/node-add (node/leaf) values))


(comment
  ;(fs/uninstrument-forms-for-namespaces ["com.dean.interval-tree.tree.tree"])

  (def a-tree (make-tree [1 -1 5 12 -99]))

  (def int-tree (make-integer-tree 10))
  (fs/local-connect)

  )