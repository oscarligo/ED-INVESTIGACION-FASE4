;; Este archivo ejecuta el programa principal de análisis climático.
;; Carga los datos, realiza el análisis de tendencias por década y genera gráficos. 



(ns climate-analysis.Main
  (:require [climate-analysis.data_loader :as data]
            [climate-analysis.analysis :as analysis]
            [climate-analysis.graph :as graph]))

;; Se ejecuta el programa principal.
(defn -main []
  (let [datos (data/cargar-datos "data/temperaturas_globales.csv")
        resumen (analysis/agrupar-por-decada datos)]
    (graph/graficar-por-decada resumen)))
