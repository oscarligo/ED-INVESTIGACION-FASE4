;; Este archivo Utiliza los datos procesados para construir gráficos de líneas por década.

;; las depencias qeu se utilizan 
(ns climate-analysis.graph
  (:use incanter.core
        incanter.charts))

;; Crea un gráfico de línea a partir de los datos de promedio por década.
(defn graficar-por-decada [resumen]
  ;; Ordena los datos por década y extrae las décadas y las temperaturas.
  (let [ordenado (sort-by key resumen)
        
        decadas (map #(* 10 (first %)) ordenado)
        temperaturas (map second ordenado)]\
    ;; Crea un gráfico de línea con los datos ordenados.
    (view (line-chart decadas temperaturas
                      :title "Tendencia de Temperatura Global por Década"
                      :x-label "Década"
                      :y-label "Anomalía de Temperatura (°C)"))))
