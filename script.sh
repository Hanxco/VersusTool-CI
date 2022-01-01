#!/bin/bash
WORKDIR="$( cd "$( dirname "$0" )" && pwd )"
DB_USER="user"
DB_PASSWORD="pasword"
DB_NAME="versusTool"
FILE_PROC="$WORKDIR/processing"
FILE_COMP="$WORKDIR/completed"

if [ -e $FILE_PROC ]
then
    clear
    echo "Files are currently being processed. Run Forrest Run!!!"
    exit
fi

if [ -e $FILE_COMP ]
then
    clear
    
    cd $WORKDIR
    
    # Make sure if job runs again to not process these files
    touch $FILE_PROC

    echo "==>"
    echo "==> ** CREATING DATABASE"
    echo "==>"
    echo "--> Cleaning up schedule tables"
    mysql -h localhost -u $DB_USER -p$DB_PASSWORD $DB_NAME < $WORKDIR/bbddScript.sql
    echo "<-- Done cleaning up schedule tables"
    
    echo "==>"
    echo "==> ** IMPORTING DATA"
    echo "==>"
    echo "--> Importing tables"
    mysqlimport -h localhost -u $DB_USER -p$DB_PASSWORD --local --delete --fields-terminated-by=',' --fields-enclosed-by='"' --ignore-lines=1 --default-character-set=utf8 $DB_NAME $WORKDIR/toolTypes.csv $WORKDIR/application.csv $WORKDIR/criteria.csv $WORKDIR/appDetail.csv 
    echo "<-- Done importing tables"

    echo "Deleting files"
    rm -f $WORKDIR/*.csv
    rm -f $FILE_PROC
    rm -f $FILE_COMP
    exit
fi

echo "Nothing to process"
