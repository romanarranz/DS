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

all: $(BIN)/bridgeStack

# ************ Ejecutables ************

$(BIN)/bridgeStack: $(OBJ)/bridgeStack.o $(OBJ)/stack.o $(OBJ)/stacklist.o $(OBJ)/stackfifo.o $(OBJ)/stackarray.o $(OBJ)/stackhanoi.o $(OBJ)/node.o
	@echo "Creando ./bin/bridgeStack..."
	@$(CXX) -o $@ $^

# ************ Objetos ************

$(OBJ)/bridgeStack.o: $(SRC)/main.cpp
	@echo "Creando ./obj/bridgeStack.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/stack.o: $(SRC)/Stack.cpp
	@echo "Creando ./obj/stack.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/stacklist.o: $(SRC)/StackList.cpp
	@echo "Creando ./obj/stacklist.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/stackfifo.o: $(SRC)/StackFIFO.cpp
	@echo "Creando ./obj/stackfifo.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/stackarray.o: $(SRC)/StackArray.cpp
	@echo "Creando ./obj/stackarray.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/stackhanoi.o: $(SRC)/StackHanoi.cpp
	@echo "Creando ./obj/stackhanoi.o..."
	@$(CXX) $(CPPFLAGS) $< -o $@

$(OBJ)/node.o: $(SRC)/Node.cpp
	@echo "Creando ./obj/node.o..."
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