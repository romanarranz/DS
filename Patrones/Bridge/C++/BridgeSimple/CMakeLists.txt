cmake_minimum_required(VERSION 3.5)
project(BridgeSimple)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES src/main.cpp include/Implementador.h include/ImplementacionA.h include/ImplementacionB.h include/Abstraccion.h include/AbstraccionRefinada.h)
add_executable(BridgeSimple ${SOURCE_FILES})