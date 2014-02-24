

<div class="visible-xs" >

  <div class="btn-group" id="actionbar">
    <button class="btn btn-default btn-success dropdown-toggle" type="button" data-toggle="dropdown">
    <g:message code="TagGroup.${params.group}" /><span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
      <g:each var="group" in="${motoranger.TagGroup.values()}">

        <g:if test="${params.group.toString() != group.toString()}">
          <li >
            <g:link action="${actionName}" id="${eventInstance?.id}" params="[group: group]" ><g:message code="TagGroup.${group}" /></g:link>
          </li>
          </g:if>
      </g:each>
    </ul>
  </div>


  <div class="btn-group" id="actionbar">
    <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
      ${params.tag ? params.tag : '選擇標籤'}<span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
      <g:each var="tag" in="${tags}" status="i">
        <g:if test="${params.tag != tag}">

          <li>
            <g:link elementId="tag-show-${i}" action="${actionName}" id="${eventInstance?.id}" params="[tag: tag, group: params.group]" >${tag}</g:link>
          </li>

        </g:if>
      </g:each>
    </ul>
  </div>
</div>


<div class="hidden-xs">
  <div class="portfolio-nav">
                
    <ul id="tagGroup" class="nav nav-pills nav-pills-portfolio">

      <g:each var="group" in="${motoranger.TagGroup.values()}">

        <li class="${ params.group.toString() == group.toString() ? 'active' : '' }">
          <g:link action="${actionName}" id="${eventInstance?.id}" params="[group: group]" ><g:message code="TagGroup.${group}" /></g:link>
        </li>
      </g:each>        

    </ul>
  </div>

  <div class="portfolio-nav">
                
    <ul data-option-key="filter" class="nav nav-pills nav-pills-portfolio">
      <g:each var="tag" in="${tags}" status="i">

        <li class="${ params.tag == tag.toString() ? 'active' : '' }">
          <g:link elementId="tag-show-${i}" action="${actionName}" id="${eventInstance?.id}" params="[tag: tag, group: params.group]" >${tag}</g:link>
        </li>
      </g:each>
    </ul>
  </div>
</div>

%{-- 維修項目項目 --}%
<div class="portfolio-grid-1 main-block row">
  <ul id="partGallery" class="thumbnails">
         
  <g:render template="/part/gallery" />

  </ul>
</div>
