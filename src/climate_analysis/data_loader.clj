;; En este archivo se cargan los datos de temperatura global desde un archivo CSV.
;; Se convierte el contenido del archivo en una lista de registros legibles por Clojure.


;;las dependencias que se utilizan
(ns climate-analysis.data_loader
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))
;; Carga los datos de un archivo CSV y los convierte en una lista de mapas.
(defn cargar-datos [ruta]
  ;; Abre el archivo CSV en la ruta,
  ;; lee su contenido y  convierte los registros en mapas usando los encabezados como claves.
  (with-open [reader (io/reader ruta)]
    (doall (csv/read-csv reader))))
