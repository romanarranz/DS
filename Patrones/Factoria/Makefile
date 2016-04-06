###############################################################################
#
# 	 Makefile
# -----------------------------------------------------------------------------
#  	Copyright (C) 2016  	  Román Arranz Guerrero  	University of Granada
# -----------------------------------------------------------------------------
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
#
###############################################################################

SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++
CC  = gcc
CPPFLAGS = -Wall -g -I$(INC) -c
OPTIMIZATION = -O3

all: $(BIN)/main

# ************ Ejecutables ************
$(BIN)/main: $(OBJ)/main.o $(OBJ)/factoriacirculo.o $(OBJ)/factoriarectangulo.o $(OBJ)/factoriatriangulo.o \
	$(OBJ)/circulo.o $(OBJ)/rectangulo.o $(OBJ)/triangulo.o
	@echo "Creando ./bin/main..."
	@$(CXX) -o $@ $^

# ************ Objetos ************
$(OBJ)/main.o: $(SRC)/main.cpp
	@echo "Creando ./obj/main.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/factoriatriangulo.o: $(SRC)/factoriatriangulo.cpp
	@echo "Creando ./obj/factoriatriangulo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/factoriarectangulo.o: $(SRC)/factoriarectangulo.cpp
	@echo "Creando ./obj/factoriarectangulo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/factoriacirculo.o: $(SRC)/factoriacirculo.cpp
	@echo "Creando ./obj/factoriacirculo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/circulo.o: $(SRC)/circulo.cpp
	@echo "Creando ./obj/circulo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/rectangulo.o: $(SRC)/rectangulo.cpp
	@echo "Creando ./obj/rectangulo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

$(OBJ)/triangulo.o: $(SRC)/triangulo.cpp
	@echo "Creando ./obj/triangulo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@ $(OPTIMIZATION)

.PHONY: clean

# ************ Limpieza ************
clean:
	@echo "Borrando ejecutables, objeto y cabeceras..."
	@rm $(BIN)/* $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~
