#!/bin/bash

YEAR=`date +%Y`
MONTH=`date +%m`
DAY=`date +%d`

mkdir -p $YEAR/$MONTH/$DAY
FILE="$YEAR/$MONTH/$DAY/readme.md"
if [ ! -f $FILE ]; then
  touch $FILE
  cat template.txt >> $FILE
fi
atom $YEAR/$MONTH/


