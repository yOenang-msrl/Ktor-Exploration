<html>
<head>
 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
 <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>
<body>
 <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-header">
 <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
 <div class="mdl-layout__header-row">
 <span class="mdl-layout-title">Home</span>
 <div class="mdl-layout-spacer"></div>
 <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
 <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
 <i class="material-icons">search</i>
 </label>
 <div class="mdl-textfield__expandable-holder">
 <input class="mdl-textfield__input" type="text" id="search">
 <label class="mdl-textfield__label" for="search">Enter your query...</label>
 </div>
 </div>
 <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
 <i class="material-icons">more_vert</i>
 </button>
 <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
 <li class="mdl-menu__item">About</li>
 <li class="mdl-menu__item">Contact</li>
 <li class="mdl-menu__item">Legal information</li>
 </ul>
 </div>
 </header>
 <main class="mdl-layout__content mdl-color--grey-100">
 <div class="mdl-grid">
 <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col">
 <thead>
 <tr>
 <th class="mdl-data-table__cell--non-numeric">Owner ID</th>
 <th class="mdl-data-table__cell--non-numeric">Start Date</th>
 <th class="mdl-data-table__cell--non-numeric">Expiry Date</th>
 <th class="mdl-data-table__cell--non-numeric">Cancelled</th>
 </tr>
 </thead>
 <tbody>
 <tr>
 <td class="mdl-data-table__cell--non-numeric">${subscriptions.userId}</td>
 <td class="mdl-data-table__cell--non-numeric">${subscriptions.packageName}</td>
 <td class="mdl-data-table__cell--non-numeric">${subscriptions.productId?date}</td>
 </tr>
 </tbody>
 </table>
 </div>
 </main>
 </div>
</body>
</html>