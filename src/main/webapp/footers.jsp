<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 17.10.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<!-- Compiled and minified JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script type="application/javascript">
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, options);
    });
    // Or with jQuery
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
