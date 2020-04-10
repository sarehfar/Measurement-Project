from scipy.stats.stats import spearmanr
import pandas as pd
import matplotlib.pyplot as plt

# Sheet name in excel file
#sheet = 'Commons Codec 1&4'
#sheet = 'Commons Collections 1&4'
#sheet = 'Commons Configuration 1&4'
#sheet = 'Maven DoxColia 1&4'
#sheet = 'Metric5&6Correlation'
#sheet = 'Commons Collections 1&3'
#sheet = 'Commons Collections 2&3'
#sheet = 'Maven DoxColia 2&3'
#sheet = 'CommonsCodec 1&3'
#sheet = 'CommonsConfiguration 1&3'
#sheet = 'CommonsConfiguration 2&3'
#sheet = 'CommonsCodec 2&3'
#sheet = 'Correlation 1 & 6'
sheet = 'Correlation 2 & 6'

# Coulmn names in excel sheet
# 1, 3 
#xCol='(3) % Mutation score' #3
#yCol='(1) % Branch coverage' #1
# 1, 4 
#xCol='(1) % Branch coverage' #1
#yCol='(4) McCabe complexColityCol' #4
# 3, 2
#xCol='(3) % Mutation score' #3
#yCol='(2) % Statement coverage' #2
# 2, 4
#xCol='(2) % Statement coverage' #2
#yCol='(4) McCabe complexColityCol' #4
# 5, 6
#xCol='(6) Post Release DD' #6
#yCol='(5) Total Churn' #5
# 6, 1
#xCol='(6) Post Release DD' #6
#yCol='(1) % Branch coverage' #1
# 6, 2
xCol='(6) Post Release DD' #6
yCol='(2) % Statement coverage' #2

# Excel File Path
fileContent = pd.read_excel(r'C:\Users\SF\Documents\PY\Correlation 1, 2 & 6.xlsx', sheet)

x = fileContent[xCol]
y = fileContent[yCol]

coefficient, value = spearmanr(x, y) # Spearman Correlation

# Plot the results
fig, ax1 = plt.subplots()
ax1.plot(x, y, 'bo')
plt.xlabel(xCol)
plt.ylabel(yCol)
plt.title(r'Spearman Correlation R=' + str(round(coefficient,2)) + ' P=' + str(round(value,4)), fontweight = "bold")
plt.savefig(sheet) # save file with this name
plt.show()
