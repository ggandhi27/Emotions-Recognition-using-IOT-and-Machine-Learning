"""Fake socket"""
import sys

def write(msg):
    sys.stdout.write("wc-socket:\n----------\n>>> %s\n\n" % msg)
