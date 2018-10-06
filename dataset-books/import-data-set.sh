#!/bin/bash
echo "Start!"
while read p; do
  curl --header "Content-Type: application/json" --request POST --data "$p" http://localhost:9200/books/book > /dev/null 2>&1
done < dataset.txt

