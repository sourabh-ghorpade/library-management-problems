(defrecord Book [title author quantity borrowed])

(defn create-book [title author quantity]
  (->Book title author quantity 0))

(defrecord Library [books])

(defn create-library []
  (->Library []))

(defn add-book [library title author quantity]
  (let [book (create-book title author quantity)]
    (assoc-in library [:books] (conj (:books library) book))
    (println "Book added to the library.")))

(defn display-books [library]
  (if (empty? (:books library))
    (println "The library is empty.")
    (do
      (println "Library Catalog:")
      (doseq [book (:books library)]
        (println (str "Title: " (:title book) ", Author: " (:author book) ", Available: " (- (:quantity book) (:borrowed book))))))))

(defn return-book [library title]
  (let [book (first (filter #(= (:title %) title) (:books library)))]
    (if book
      (if (>= (:borrowed book) 0)
        (do
          (assoc-in library [:books] (map #(if (= (:title %) title) (assoc % :borrowed (dec (:borrowed %))) %) (:books library)))
          (println "Book returned successfully."))
        (println "You haven't borrowed this book."))
      (println "Book not found in the library."))))

(defn -main []
  (def library (atom (create-library)))

  (loop []
    (println "\nLibrary Management System")
    (println "1. Add Book")
    (println "2. Display Available Books")
    (println "3. Borrow Book")
    (println "4. Return Book")
    (println "5. Quit")

    (print "Enter your choice: ")
    (flush)
    (def choice (read-line))

    (case choice
      "1" (do
            (print "Enter book title: ")
            (flush)
            (def title (read-line))
            (print "Enter author name: ")
            (flush)
            (def author (read-line))
            (print "Enter quantity available: ")
            (flush)
            (def quantity (Integer/parseInt (read-line)))
            (add-book @library title author quantity))
      "2" (display-books @library)
      "4" (do
            (print "Enter the title of the book you want to return: ")
            (flush)
            (def title (read-line))
            (return-book @library title))
      "5" (do (println "Exiting the library system.") (System/exit 0))
      (do (println "Invalid choice. Please try again.") (recur)))))
