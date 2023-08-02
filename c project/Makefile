# Compiler and compiler flags
CC := gcc
CFLAGS := -Wall -Wextra

# Directories
SRC_DIR := src
OBJ_DIR := obj

# Source files
SRCS := $(wildcard $(SRC_DIR)/*.c)
OBJS := $(patsubst $(SRC_DIR)/%.c, $(OBJ_DIR)/%.o, $(SRCS))

# Target binary
TARGET := clox

# Phony targets
.PHONY: all clean

# Default target
all: $(TARGET)

# Compile and build the target binary
$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) $(OBJS) -o $(TARGET)

# Compile source files into object files
$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c
	@mkdir -p $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Clean the object files and the target binary
clean:
	rm -rf $(OBJ_DIR) $(TARGET)