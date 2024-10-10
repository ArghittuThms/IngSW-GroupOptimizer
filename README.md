# Group Optimizer - Software Engineering Project, University of Udine


## Overview

This project is part of the Software Engineering course at the University of Udine. It aims to optimize groupings of elements based on data provided in a CSV file, calculating the best possible groups by maximizing an average score between group pairs.

The project consists of several Java classes that handle:

1. **CSV Data Loading**: Parsing data from a CSV file and organizing it into an internal data structure.
2. **Combination Generation**: Generating possible group combinations by swapping elements from an initial list.
3. **Group Optimization**: Calculating and selecting the optimal groups based on a calculated average score.

## Usage

To use the project, follow these steps:

### Prerequisites
- Java JDK 8 or higher
- A CSV file (e.g., `data.csv`) formatted with rows of scores between elements (see [data.csv file](./data.csv))

## Workflow
The program will:
- Load data from the CSV file specified in the `CSV_PATH` variable.
- Print the loaded data (if enabled).
- Calculate the optimal groupings based on the provided data.
- Print the final groups and their average score.

### Main Classes

- **Main**: The entry point of the application. It loads the CSV, calculates the best groups, and prints the result.
- **Group**: Manages the core logic of reading data, optimizing groups, and calculating scores.
- **CombinationFinder**: Generates different combinations of elements and manages the swapping logic.
- **DataCSV**: Utility class for loading data from the CSV file.

## License

This project is for educational purposes only as part of the Software Engineering course at the University of Udine.

