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

all: $(BIN)/fachada

# ************ Ejecutables ************

$(BIN)/fachada: $(OBJ)/fachada.o $(OBJ)/line.o $(OBJ)/point.o $(OBJ)/pointcarte.o $(OBJ)/pointpolar.o
	@echo "Creando ./bin/fachada..."
	@$(CXX) -o $@ $^

# ************ Objetos ************

$(OBJ)/fachada.o: $(SRC)/main.cpp
	@echo "Creando ./obj/fachada.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/line.o: $(SRC)/Line.cpp
	@echo "Creando ./obj/line.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/point.o: $(SRC)/Point.cpp
	@echo "Creando ./obj/point.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/pointcarte.o: $(SRC)/Pointcarte.cpp
	@echo "Creando ./obj/pointcarte.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/pointpolar.o: $(SRC)/Pointpolar.cpp
	@echo "Creando ./obj/pointpolar.o..."
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