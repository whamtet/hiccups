(defproject org.clojars.whamtet/hiccups "0.4.1"
  :description "A ClojureScript port of Hiccup - a fast library for rendering HTML in ClojureScript"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  ;; Required by cljsbuild  plugin
  :min-lein-version "2.2.0"

  ;; We need to add src/cljs too, because cljsbuild does not add its
  ;; source-paths to the project source-paths
  :source-paths ["src/clj" "src/cljs"]

  ;; The libs which the project depends on.
  ;; Here we use the latest stable clj and cljs releases
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.516"]]

  ;; The plugins which the project depends on. Here we're using the
  ;; experimental 1.0.0-alpha2 release. Change it to the official
  ;; 1.0.0 as soon as it will be available
  :plugins [[lein-cljsbuild "1.1.7"]]

  ;; Hooks the cljsbuild subtasks to the lein tasks: lein clean, lein
  ;; compile, lein test and lein jar
  :hooks [leiningen.cljsbuild]

  ;; Lein-cljsbuild plugin configuration. Here we define one build
  ;; only: the one used for packaging any cljs sources in the jar
  ;; generated by lein jar command
  :cljsbuild
  {:builds {;; This build is only used for including any cljs source
            ;; in the packaged jar when you issue lein jar command and
            ;; any other command that depends on it
            :useless
            {;; The dir pathnames where cljs sources live. Do not
             ;; include here any cljs source which is only used during
             ;; development or testing
             :source-paths ["src/cljs"]
             ;; The :jar true option is not needed to include the CLJS
             ;; sources in the packaged jar. This is because we added
             ;; the CLJS source codebase to the Leiningen
             ;; :source-paths
             ;:jar true
             ;; Compilation Options
             :compiler
             {;; The JS file pathname emitted by the compiler
              :output-to "dev-resources/public/js/useless.js"
              ;; Compiler optimizations option set to :none to speed
              ;; up this useless compilation
              :optimizations :none
              ;; No need to prettify the emitted js file
              :pretty-print false}}}})
