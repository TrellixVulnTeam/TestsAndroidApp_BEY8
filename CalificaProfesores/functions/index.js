const functions = require('firebase-functions');

const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
exports.SendVote = functions.https.onRequest((request, response) => {
  console.log("Peticion de voto \n");

  /// verificamos login del usuario
  admin.auth().verifyIdToken(request.headers.authorization).then(decodedIdToken => {
    //admin.auth().getUser(uid).then(function(userRecord) {
      console.log("User: ",decodedIdToken.displayName);
      console.log("CA: " , request.headers.CA);
      console.log("CE: " , request.headers.CE);
      console.log("A : " , request.headers.A);
      console.log("Professor Id: " , request.headers.ProfId);
      console.log("Subject Id: ", request.headers.MatId);
    //})
    //.catch(function(error) {
   //   console.log("Error fetching user data:", error);
   // });
    
   return 1;
    
  }).catch(error => {
    console.error('Error while verifying Firebase ID token:', error);
    response.status(403).send('Unauthorized');
  });
  return 1;
});



