#!/bin/bash

YEAR=`date +%Y`
MONTH=`date +%m`
DAY=`date +%d`

mkdir -p $YEAR/$MONTH/$DAY
touch $YEAR/$MONTH/$DAY/readme.md
atom $YEAR/$MONTH/$DAY/readme.md


