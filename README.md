1. This project is created using the Spring initialzr starter pack which has all the required slf4j and junit dependencies 
2. The purpose of this app is to read a set of transactions from a csv file and identify relative balace for a said account number between 2 dates
3. To run the program, use the driver class ApplicationDriver
4. Pass in the path of the file with the list of transaction records, account number whose relative balance is required and the from and to dates as the arguements to the driver class
For instance: java -jar TransactionAnalyser-0.0.1-SNAPSHOT.jar "data/TransactionRecords.csv" "ACC334455" "20/10/2018 12:00:00" "20/10/2018 19:00:00"