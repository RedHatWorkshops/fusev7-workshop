/**
 * 
 */

angular.module( 'patternfly.card' ).controller( 'CardDemoCtrl', function( $scope, $window, $timeout ) {
   var imagePath = $window.IMAGE_PATH || "img";

   $scope.dataLoading = true;

   $scope.status = {
     "title":"Nodes",
     "href":"#",
     "iconClass": "fa fa-shield",
     "notifications":[]
   };

     $scope.status2 = {
       "title":"Nodes",
       "count":793,
       "href":"#",
       "iconClass": "fa fa-shield",
       "notifications":[
         {
           "iconClass":"pficon pficon-error-circle-o",
           "count":4,
           "href":"#"
         },
         {
           "iconClass":"pficon pficon-warning-triangle-o",
           "count":1
         }
       ]
     };
   $scope.aggStatusAlt = {
     "title":"Providers",
     "count":3,
     "notifications":[
       {
         "iconImage": imagePath + "/kubernetes.svg",
         "count":1,
         "href":"#"
       },
       {
         "iconImage": imagePath + "/OpenShift-logo.svg",
         "count":2,
         "href":"#"
       }
     ]
   };

     $scope.aggStatusAlt2 = {
       "title":"Providers",
       "notifications":[]
     };

   $timeout(function () {
     $scope.dataLoading = false;

     $scope.status = {
       "title":"Nodes",
       "count":793,
       "href":"#",
       "iconClass": "fa fa-shield",
       "notifications":[
         {
           "iconClass":"pficon pficon-error-circle-o",
           "count":4,
           "href":"#"
         },
         {
           "iconClass":"pficon pficon-warning-triangle-o",
           "count":1
         }
       ]
     };

     $scope.aggStatusAlt2 = {
       "title":"Providers",
       "count":3,
       "notifications":[
         {
           "iconImage": imagePath + "/kubernetes.svg",
           "count":1,
           "href":"#"
         },
         {
           "iconImage": imagePath + "/OpenShift-logo.svg",
           "count":2,
           "href":"#"
         }
       ]
     };
   }, 6000 );

   $scope.miniAggStatus = {
     "iconClass":"pficon pficon-container-node",
     "title":"Nodes",
     "count":52,
     "href":"#",
     "notification": {
       "iconClass":"pficon pficon-error-circle-o",
       "count":3
     }
   };

   $scope.miniAggStatus2 = {
     "iconClass":"pficon pficon-cluster",
     "title":"Adipiscing",
     "count":9,
     "href":"#",
     "notification":{
       "iconClass":"pficon pficon-ok"
     }
   };
  });
