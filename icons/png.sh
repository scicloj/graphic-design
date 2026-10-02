#!/bin/sh
for file in *.svg; do rsvg-convert -o "${file%.svg}.png" "$file"; done

