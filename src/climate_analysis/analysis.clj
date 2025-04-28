;; En este archivo se  procesan los datos de temperatura global para calcular promedios por década.
;; Separa los datos por década y calcula las anomalías de temperatura promedio.

(ns climate-analysis.analysis)

;; Esta función toma una fila de datos y la convierte en un mapa con claves :año y :temp.
(defn parse-row [[año temp]]
  {:año (Integer/parseInt año)
   :temp (Float/parseFloat temp)})

;; Esta función agrupa los datos por década y calcula la temperatura promedio para cada década.
(defn agrupar-por-decada [datos]
  (let [filas (map parse-row (rest datos))] ; Saltar el encabezado
    (->> filas
         (group-by #(int (/ (:año %) 10))) ; Agrupar por década
         (into {} (map (fn [[decada registros]]
                         [decada
                          (/ (reduce + (map :temp registros))
                             (count registros))]))))))
