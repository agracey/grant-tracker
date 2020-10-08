(ns grant-tracker-ui.layout.header
    (:require
      [reagent.core :as r]))

(defn account-menu []
  (let [name "Andrew"]
    [:div.welcome
      "Hello " 
      name]))

(defn page-header [] 
  [:header.page-header
    [:img.logo.float-left 
      {:src "/public/images/logo.png" 
      :height "32px" 
      :width "18px"}]
    [:div.float-right
      (account-menu)]])

