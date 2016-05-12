(function (){

    var app = angular.module('millestone-delivery', []);

    app.controller("MillestoneController", function (user, $scope) {
        var self = this;
        
        self.addMilestone = function(shipment){
              console.log(self.newMilestone.body);

              self.newMilestone.date = Date.now();

              user.postNewHitoToShipment(shipment.id, self.newMilestone)
                      .then(handleRequest(),handleBadRequest());

        };
        
        function handleRequest(res) {
            $scope.delivery.milestoneList.push(self.newMilestone);
            self.newMilestone = {};

        };
        
        function handleBadRequest(res) {
            self.newMilestone = {};

        };

    });
})();
