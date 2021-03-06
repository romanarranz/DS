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
CPPFLAGS = -Wall -std=c++11 -g -I$(INC) -O3 -c

MAKEFILE_PATH = $(abspath $(lastword $(MAKEFILE_LIST)))
CURRENT_DIR = $(lastword $(notdir $(patsubst %/,%,$(dir $(MAKEFILE_PATH)))))

all: $(BIN)/builder

# ************ Ejecutables ************

$(BIN)/builder: $(OBJ)/builder.o $(OBJ)/waiter.o $(OBJ)/pizza.o $(OBJ)/pizzabuilder.o $(OBJ)/spicypizzabuilder.o $(OBJ)/hawaiianpizzabuilder.o
	@echo "Creando ./bin/builder..."
	@$(CXX) -o $@ $^

# ************ Objetos ************

$(OBJ)/builder.o: $(SRC)/main.cpp
	@echo "Creando ./obj/builder.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/waiter.o: $(SRC)/waiter.cpp
	@echo "Creando ./obj/waiter.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/pizza.o: $(SRC)/pizza.cpp
	@echo "Creando ./obj/pizza.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/pizzabuilder.o: $(SRC)/pizzabuilder.cpp
	@echo "Creando ./obj/pizzabuilder.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/spicypizzabuilder.o: $(SRC)/spicypizzabuilder.cpp
	@echo "Creando ./obj/spicypizzabuilder.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/hawaiianpizzabuilder.o: $(SRC)/hawaiianpizzabuilder.cpp
	@echo "Creando ./obj/hawaiianpizzabuilder.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

.PHONY: clean zip tar

# ************ Limpieza ************
clean:
	@echo "Borrando ejecutables, objeto y cabeceras..."
	@rm $(BIN)/* $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

# ************ Compresion ************
zip:
	@echo "Creando "$(CURRENT_DIR)".zip..."
	zip $(CURRENT_DIR) -r src obj input include bin

tar:
	@echo "Creando "$(CURRENT_DIR)".tar.gz..."
	tar -cvzf $(CURRENT_DIR).tar.gz src obj input include bin