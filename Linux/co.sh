#!/bin/bash
# co command for Linux

if [ "$1" = "-o" ]; then
    shift  # Remove the '-o' argument from the argument list
    echo "$(eval "$*" 2>&1)"
else
    echo -n "$(eval "$@" 2>&1)" | xclip -selection clipboard
fi

echo "Command output copied to clipboard successfully!"
