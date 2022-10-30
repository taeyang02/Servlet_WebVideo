import numpy as np
import cv2
import tensorflow as tf
# Using laptop’s webcam as the source of video
cap = cv2.VideoCapture(0)
cap.set(3, 480)  # ID 3 = width
cap.set(4, 320)  # ID 4 = height
i = 0
# Labels — The various outcome possibilities
# labels = ["admin","quannv","thanhmx"]
# labelsName = ["Dong Thai Duong","Nguyen Van Quan","Mai Xuan Thanh"]
labels = ["admin","thanhmx","phuongtt","vott"]
labelsName = ["Dong Thai Duong","Mai Xuan Thanh","Mai Duong Phuong","Nguyen Tien Vo"]
# Loading the model weigths we just downloaded
model = tf.keras.models.load_model("keras_model.h5", compile = False)
while True:
    success, image = cap.read()
    if success == False:
        break
    image = cv2.flip(image, 1)
    # cv2.imshow("Frame", image)
    img = cv2.resize(image, (224, 224))
    # Convert the image to a numpy array
    img = np.array(img, dtype=np.float32)
    img = np.expand_dims(img, axis=0)
    # Normalizing input imageq
    img = img / 255
    # Predict the class
    prediction = model.predict(img)
    # Map the prediction to the labels
    # Rnp.argmax returns the indices of the maximum values along an axis.
    predicted_labels = labels[np.argmax(prediction[0], axis=-1)]
    predicted_labels_Name = labelsName[np.argmax(prediction[0], axis=-1)]
    ret, frame = cap.read()
    font = cv2.FONT_HERSHEY_SIMPLEX
    cv2.putText(frame, 
                predicted_labels_Name, 
                (50, 50), 
                font, 1, 
                (0, 255, 255), 
                2, 
                cv2.LINE_4)
    # Display the resulting frame
    cv2.imshow('video', frame)
    i=i+1
#    print(predicted_labels)
    # print(predicted_labels, np.argmax(prediction[0], axis=-1), prediction[0])
    # print(predicted_labels)
    print(str(i))
    wfx = open('data.txt','r')
    masu = wfx.read()
    if(predicted_labels != masu):
        i=0
        wfx = open('data.txt', 'w')
        wfx.write(predicted_labels)
    if(i == 50):
        wf = open('data.txt', 'w')
        wf.write(predicted_labels)
        # wfisRun = open('isRunning.txt', 'w')
        wfisRunStop = open('isRunning.txt', 'w')
        wfisRunStop.write("stop")
        break
    # Close all windows if one second has passed and ‘q’ is pressed
    if cv2.waitKey(1) & 0xFF == ord('q'):
        wf = open('data.txt', 'w')
        wf.write(predicted_labels)
        # wfisRun = open('isRunning.txt', 'w')
        wfisRunStop = open('isRunning.txt', 'w')
        wfisRunStop.write("stop")
        break

# Release open connections
cap.release()
cv2.destroyAllWindows()