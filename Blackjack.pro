TEMPLATE = app
CONFIG += console
CONFIG -= app_bundle
CONFIG -= qt
CONFIG += c++11

SOURCES += main.cpp \
    card.cpp \
    deck.cpp \
    blackjack.cpp

HEADERS += \
    card.h \
    deck.h \
    blackjack.h
