#!/bin/bash

currentDir=$(cd $(dirname $0); pwd)
echo $rootDir

YEAR=`date +%Y`
MONTH=`date +%m`
DAY=`date +%d`

mkdir -p $currentDir/$YEAR/$MONTH/$DAY
FILE="$currentDir/$YEAR/$MONTH/$DAY/readme.md"
if [ ! -f $FILE ]; then
  touch $FILE
  cat $currentDir/template.txt >> $FILE
fi
atom $currentDir/$YEAR/$MONTH/


