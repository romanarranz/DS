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

# ************ Deprecated Interface ************
ifeq ($(x86_64),1)
	@echo "x86_64 variable has been deprecated"
    @echo "please use TARGET_ARCH=x86_64 instead"
    TARGET_ARCH ?= x86_64
endif

# ************ Architecture ************
HOST_ARCH   := $(shell uname -m)
TARGET_ARCH ?= $(HOST_ARCH)
ifneq (,$(filter $(TARGET_ARCH),x86_64 aarch64 ppc64le))
    TARGET_SIZE := 64
else ifeq ($(TARGET_ARCH),armv7l)
    TARGET_SIZE := 32
else
    $(error ERROR - unsupported value $(TARGET_ARCH) for TARGET_ARCH!)
endif
ifneq ($(TARGET_ARCH),$(HOST_ARCH))
    ifeq (,$(filter $(HOST_ARCH)-$(TARGET_ARCH),aarch64-armv7l x86_64-armv7l x86_64-aarch64 x86_64-ppc64le))
        $(error ERROR - cross compiling from $(HOST_ARCH) to $(TARGET_ARCH) is not supported!)
    endif
endif

# ************ OS ************
HOST_OS   := $(shell uname -s 2>/dev/null | tr "[:upper:]" "[:lower:]")
TARGET_OS ?= $(HOST_OS)
ifeq (,$(filter $(TARGET_OS),linux darwin qnx android))
    $(error ERROR - unsupported value $(TARGET_OS) for TARGET_OS!)
endif

SRC := src
INC := include
OBJ := obj
BIN := bin
LIB :=
CXX := g++-5
CC  := gcc-5

DEBUG := -Wall -g
PROD := -O3

CFLAGS := $(PROD) -I$(INC)
LDFLAGS := -L/usr/local/lib

MAKEFILE_PATH = $(abspath $(lastword $(MAKEFILE_LIST)))
CURRENT_DIR = $(lastword $(notdir $(patsubst %/,%,$(dir $(MAKEFILE_PATH)))))

all: binaries cleanup
binaries: adapter

# ************ Ejecutables ************

adapter: $(OBJ)/main.o $(OBJ)/LegacyRectangle.o $(OBJ)/RectangleAdapter.o
	@echo "Creando $@..."
	@mkdir -p $(BIN)/$(TARGET_ARCH)/$(TARGET_OS)
	@$(CXX) $(CFLAGS) $(LDFLAGS) -o $@ $+
	@mv $@ $(BIN)/$(TARGET_ARCH)/$(TARGET_OS)

# ************ Objetos ************

$(OBJ)/main.o: $(SRC)/main.cpp
	@echo "Creando $@..."
	@$(CXX) $(CFLAGS) -c $< -o $@

$(OBJ)/LegacyRectangle.o: $(SRC)/LegacyRectangle.cpp
	@echo "Creando $@..."
	@$(CXX) $(CFLAGS) -c $< -o $@

$(OBJ)/RectangleAdapter.o: $(SRC)/RectangleAdapter.cpp
		@echo "Creando $@..."
		@$(CXX) $(CFLAGS) -c $< -o $@

# ************ Clean UP ************
cleanup:
ifeq ($(TARGET_OS),darwin)
	@rm -r *.dSYM
endif

.PHONY: clean license

# ************ Limpieza ************
clean:
	@echo "Borrando ejecutables, objeto y cabeceras..."
	@rm -r $(BIN)/* $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

license:
	@echo "Generando licencia..."
	@license install mit -y 2016 -n "ROMÁN ARRANZ GUERRERO"
