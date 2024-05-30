#!/bin/bash

# Check if search text and folder are provided
if [ $# -ne 2 ]; then
    echo "Usage: $0 <search_text> <folder>"
    exit 1
fi

SEARCH_TEXT=$1
SEARCH_FOLDER=$2
OUTPUT_FOLDER="./${SEARCH_TEXT}_results"

# Create output folder
mkdir -p "$OUTPUT_FOLDER"

# Function to process each log file
process_log_file() {
    local logfile=$1
    local relative_path=$2

    # Find the first and last occurrence of the search text
    FIRST_OCCURRENCE=$(grep -nm 1 "$SEARCH_TEXT" "$logfile" | cut -d: -f1)
    LAST_OCCURRENCE=$(grep -n "$SEARCH_TEXT" "$logfile" | tail -n 1 | cut -d: -f1)

    # If the search text is not found, skip the file
    if [ -z "$FIRST_OCCURRENCE" ] || [ -z "$LAST_OCCURRENCE" ]; then
        return
    fi

    # Calculate the start and end lines
    START_LINE=$((FIRST_OCCURRENCE - 10))
    END_LINE=$((LAST_OCCURRENCE + 10))

    # Ensure the start line is not less than 1
    if [ $START_LINE -lt 1 ]; then
        START_LINE=1
    fi

    # Ensure the end line does not exceed the total number of lines in the file
    TOTAL_LINES=$(wc -l < "$logfile")
    if [ $END_LINE -gt $TOTAL_LINES ]; then
        END_LINE=$TOTAL_LINES
    fi

    # Create subfolder structure in the output folder
    OUTPUT_SUBFOLDER="$OUTPUT_FOLDER/$relative_path"
    mkdir -p "$OUTPUT_SUBFOLDER"

    # Extract and copy the required lines to a new file
    OUTPUT_FILE="$OUTPUT_SUBFOLDER/$(basename "$logfile")"
    sed -n "${START_LINE},${END_LINE}p" "$logfile" > "$OUTPUT_FILE"
}

export -f process_log_file
export SEARCH_TEXT
export OUTPUT_FOLDER

# Find all log files and process them
find "$SEARCH_FOLDER" -type f -name "*.log" -exec bash -c 'process_log_file "$0" "${0#./$SEARCH_FOLDER/}"' {} \;

# Create a folder named with the search text and move all files there
mv "$OUTPUT_FOLDER" "./${SEARCH_TEXT}"
