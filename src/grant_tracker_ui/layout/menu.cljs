(ns grant-tracker-ui.layout.menu
    (:require
      [secretary.core :as secretary]
      [reagent.core :as r]))


(defn browse-to [path] 
  (js/console.log path)
  (secretary/dispatch! path))

(defn build-submenu-item [route] 
  [:li.sub-menu-item {:key (route :title )}
    [:div.title {:on-click #(secretary/dispatch! (route :path))}
      (route :title)]])

(defn build-submenu [sub-menu] 
  [:ul.sub-menu
    (map build-submenu-item sub-menu)])

(defn build-menu-item [route]
  [:li.menu-item {:key (route :title)}
    [:div.title {:on-click 
      #(browse-to (route :path))}
      (route :title)]
    (build-submenu (route :sub-menu))])

(defn page-menu [route-list]
  [:nav.page-menu {:class "expanded"} ;TODO create ATOM for sidebar state
    [:div.expander "FA hamburger"]
    [:ul 
      (map build-menu-item route-list)]])